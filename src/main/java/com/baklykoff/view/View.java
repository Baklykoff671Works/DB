package com.baklykoff.view;

import com.baklykoff.controller.*;
import com.baklykoff.controller.interfaces.GeneralController;
import com.baklykoff.model.models.*;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements Printable {
    private final Map<String, GeneralController> controllers;
    private final Map<String, GeneralModel> models;
    private final Scanner input;
    boolean isQuit;
    private String consoleInput;

    public View() {
        input = new Scanner(System.in, StandardCharsets.UTF_8);
        isQuit = false;
        models = new HashMap<>();
        controllers = new HashMap<>();
        controllers.put("Attraction", new AttractionController());
        controllers.put("Park", new ParkController());
        controllers.put("ParkAttraction", new ParkAttractionController());
        controllers.put("Paydesk", new PaydeskController());
        controllers.put("ShowEntertainment", new ShowEntertainmentController());
        controllers.put("Ticket", new TicketController());
        controllers.put("Visitor", new VisitorController());
        controllers.put("Worker", new WorkerController());


        models.put("Park", new Park());
        models.put("Ticket", new Ticket());
        models.put("Attraction", new Attraction());
        models.put("Paydesk", new Paydesk());
        models.put("ShowEntertainment", new ShowEntertainment());
        models.put("Worker", new Worker());
        models.put("Visitor", new Visitor());
        models.put("ParkAttraction", new ParkAttraction());
        print();
    }

    @Override
    public void print() {
        while (!isQuit) {
            try {
                System.out.println("Type in console key to choose option(key - option):");
                System.out.println(getTables());
                consoleInput = input.nextLine().toUpperCase();
                switch (consoleInput) {
                    case "P" -> printMethodModel("Park");
                    case "A" -> printMethodModel("Attraction");
                    case "PA" -> printMethodModel("ParkAttraction");
                    case "PAY" -> printMethodModel("Paydesk");
                    case "W" -> printMethodModel("Worker");
                    case "SE" -> printMethodModel("ShowEntertainment");
                    case "V" -> printMethodModel("Visitor");
                    case "T" -> printMethodModel("Ticket");
                    case "Q" -> isQuit = true;
                    default -> System.out.println("invalid input");
                }
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }
    }

    private void printMethodModel(String table) throws SQLException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println(getMethodModel(table));
            consoleInput = input.nextLine().toUpperCase();
            switch (consoleInput) {
                case "FA" -> {
                    System.out.println(controllers.get(table).printColumns());
                    printFindAll(controllers.get(table));
                }
                case "FBI" -> {
                    System.out.println(controllers.get(table).printColumns());
                    printFindById(controllers.get(table));
                }
                case "C" -> {
                    System.out.println(controllers.get(table).printColumns());
                    createModel(controllers.get(table), models.get(table));
                }
                case "U" -> {
                    System.out.println(controllers.get(table).printColumns());
                    updateModel(controllers.get(table), models.get(table));
                }
                case "D" -> {
                    delete(controllers.get(table));
                }
                case "B" -> isBack = true;
                default -> System.out.println("invalid input");
            }
        }
    }

    private String getTables() {
        StringBuffer str = new StringBuffer();
        str.append("    P - Park\n");
        str.append("    A - Attraction\n");
        str.append("    PA - ParkAttraction\n");
        str.append("    PAY - Paydesk\n");
        str.append("    W - Worker\n");
        str.append("    SE - ShowEntertainment\n");
        str.append("    V - Visitor\n");
        str.append("    T - Ticket\n");
        str.append("    Q - quit\n");
        return str.toString();
    }

    private String getMethodModel(String table) {
        StringBuffer str = new StringBuffer();
        str.append("Table" + table + "\n");
        str.append("  FA - Find All " + table + "`s\n");
        str.append("  FBI - Find by id " + table + "`s\n");
        str.append("  C - Create " + table + "`s\n");
        str.append("  U - Update " + table + "`s\n");
        str.append("  D - Delete " + table + "`s\n");
        str.append("  B - back \n");
        return str.toString();
    }

    private void printFindAll(GeneralController controller) throws SQLException {
        for (Object a : controller.findAll()) {
            System.out.println(a);
        }
    }

    private void printFindById(GeneralController controller) throws SQLException {
        System.out.println("Print id of model:");
        consoleInput = input.nextLine();
        System.out.println(controller.findById(Integer.parseInt(consoleInput)));
    }

    private void createModel(GeneralController controller, GeneralModel model) throws SQLException {
        controller.create(getModel(model, false));
        System.out.println("Success");
    }

    private void updateModel(GeneralController controller, GeneralModel model) throws SQLException {
        model = getModel(model, true);
        if (model == null) {
            System.out.println("Bad input");
        } else {
            controller.update(model);
            System.out.println("Success");
        }
    }

    private GeneralModel getModel(GeneralModel model, boolean isToUpdate) {
        try {
            model = model.getClass().getConstructor().newInstance();
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName() == "id" && !isToUpdate) {
                    continue;
                }
                System.out.println("Print value of " + field.getName() + " type " + field.getAnnotatedType() + ": ");
                consoleInput = input.nextLine();
                field.setAccessible(true);
                switch (field.getAnnotatedType().toString()) {
                    case "java.lang.Integer":
                        field.set(model, Integer.parseInt(consoleInput));
                        break;
                    case "java.lang.String":
                        field.set(model, consoleInput);
                        break;
                    case "java.lang.Float":
                        field.set(model, Float.parseFloat(consoleInput));
                        break;
                    case "java.lang.Double":
                        field.set(model, Double.parseDouble(consoleInput));
                        break;
                    case "com.baklykoff.model.models.Attraction":
                        field.set(model, controllers.get("Attraction").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.Park":
                        field.set(model, controllers.get("Park").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.ParkAttraction":
                        field.set(model, controllers.get("ParkAttraction").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.Paydesk":
                        field.set(model, controllers.get("Paydesk").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.ShowEntertainment":
                        field.set(model, controllers.get("ShowEntertainment").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.Ticket":
                        field.set(model, controllers.get("Ticket").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.Visitor":
                        field.set(model, controllers.get("Visitor").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.baklykoff.model.models.Worker":
                        field.set(model, controllers.get("Worker").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "java.sql.Date":
                        field.set(model, Date.valueOf(consoleInput));
                        break;
                    default:
                        break;
                }
            }
            return model;
        } catch (Exception e) {
            System.out.println("bad input" + e);
        }
        return null;
    }

    public void delete(GeneralController controller) throws SQLException {
        System.out.println("Print id of model to delete:");
        consoleInput = input.nextLine();
        System.out.println("Success");
        System.out.println(controller.delete(Integer.parseInt(consoleInput)));
    }
}
