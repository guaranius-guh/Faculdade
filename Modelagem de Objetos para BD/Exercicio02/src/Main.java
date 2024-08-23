import dao.*;
import entity.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Engineer engineer = new Engineer("Wellington", "Civil");
        Equipment equipment = new Equipment("Concrete Mixer", "Construction");
        Material material = new Material("Concrete", 50);
        Project project = new Project("Big Tower", "New York", "2024-08-22", "2024-08-30");
        Worker worker = new Worker("John", "Put Glass");

        EngineerDAO engineerDAO = new EngineerDAO();
        //engineerDAO.create();
        //engineerDAO.insert(engineer);
        //engineerDAO.update(engineer);
        //engineerDAO.delete(engineer);
        /*for(var a : engineerDAO.getAll()) {
            System.out.println(a);
        }*/
        /*for(var a : engineerDAO.engineersPerProject(project.getId_project())) {
            System.out.println(a);
        }*/

        EquipmentDAO equipmentDAO = new EquipmentDAO();
        //equipmentDAO.create();
        //equipmentDAO.insert(equipment);
        //equipmentDAO.update(equipment);
        //equipmentDAO.delete(equipment);
        /*for(var a : equipmentDAO.getAll()) {
            System.out.println(a);
        }*/
        /*for(var a : equipmentDAO.equipmentPerProject(project.getId_project())) {
            System.out.println(a);
        }*/

        MaterialDAO materialDAO = new MaterialDAO();
        //materialDAO.create();
        //materialDAO.insert(material);
        //materialDAO.update(material);
        //materialDAO.delete(material);
        /*for(var a : materialDAO.getAll()) {
            System.out.println(a);
        }*/
        /*for(var a : materialDAO.materialsPerProject(project.getId_project())) {
            System.out.println(a);
        }*/

        ProjectDAO projectDAO = new ProjectDAO();
        //projectDAO.create();
        engineer.setId_engineer(1);
        project.getEngineers().add(engineer);
        projectDAO.insert(project);
        //projectDAO.update(project);
        //projectDAO.delete(project);
        /*for(var a : projectDAO.getAll()) {
            System.out.println(a);
        }*/

        WorkerDAO workerDAO = new WorkerDAO();
        //workerDAO.create();
        //workerDAO.insert(worker);
        //workerDAO.update(worker);
        //workerDAO.delete(worker);
        /*for(var a : workerDAO.getAll()) {
            System.out.println(a);
        }*/
        /*for(var a : workerDAO.workersPerProject(project.getId_project())) {
            System.out.println(a);
        }*/
    }
}
