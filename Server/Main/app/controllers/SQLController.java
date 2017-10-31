package SQL;

import com.fasterxml.jackson.databind.JsonNode;
import org.h2.jdbcx.JdbcConnectionPool;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Lars Badde
 */
@Singleton
public class SQLController extends Controller {

    public static JdbcConnectionPool cp = JdbcConnectionPool.create(
            "jdbc:h2:file:./nui", "lars", "password");

    public static class Workstation {
        public Long id;
        public String name;
        public String description;
    }

    public static class Device {
        public Long id;
        public String name;
        public String description;
        public Long assignedTo;
    }

    public static class Person {
        public Long id;
        public String prename;
        public String surname;
    }

    public static class TrackingEvent {
        public Long id;
        public String origin;
        public Long timestamp;
        public JsonNode data;
    }

    public static void addWorkstationToDB(Workstation workstation) throws SQLException {
        Connection connection = cp.getConnection();
        connection.createStatement().execute("INSERT INTO workstations (name, description) VALUES ('" + workstation.name + "','" + workstation.description + "')");
        connection.close();
    }

    public static void addDeviceToDB(Device device) throws SQLException {
        Connection connection = cp.getConnection();
        connection.createStatement().execute("INSERT INTO devices (name, description, assignedTo) VALUES ('" + device.name + "','" + device.description + "'," + device.assignedTo + ")");
        connection.close();
    }

    public static void addPersonToDB(Person person) throws SQLException {
        Connection connection = cp.getConnection();
        connection.createStatement().execute("INSERT INTO persons (prename, surname) VALUES ('"+ person.prename + "','" + person.surname + "')");
        connection.close();
    }

    public static void addEventToDB(TrackingEvent event) throws SQLException {
        Connection connection = cp.getConnection();
        System.out.println("Adding: "+event.origin+" || "+event.timestamp+" || "+event.data.toString());
        connection.createStatement().execute("INSERT INTO events (origin, timestamp, data) VALUES ('"+ event.origin + "'," + event.timestamp + ",'"+event.data.toString()+"')");
        connection.close();
    }



    public static void assignDeviceToWorkstation(Long DeviceID, Long WorkStationID) throws SQLException {
        Connection connection = cp.getConnection();
        connection.createStatement().execute("UPDATE devices SET assignedTO = " + WorkStationID + " WHERE id = " + DeviceID + ";");
        connection.close();
    }

    public static List<Long> getAssignedDevices(Long WorkStationID) throws SQLException {
        Connection connection = cp.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT id FROM devices WHERE assignedTo =" + WorkStationID + ";");

        List<Long> assignedDevices = new ArrayList<Long>();
        while (rs.next()) {
            assignedDevices.add(rs.getLong(1));
        }


        connection.close();
        return assignedDevices;
    }

    public static Long getDeviceID(String name) throws SQLException {
        Connection connection = cp.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT id FROM devices WHERE name ='" + name + "';");
        Long id=null;
        while (rs.next()) {
            id = rs.getLong(1);
        }
        connection.close();
        return id;
    }

    public static Long getDevicesWorkstation(Long id) throws SQLException {
        Connection connection = cp.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT assignedTo FROM devices WHERE id =" + id + ";");
        Long ws=null;
        while (rs.next()) {
            ws = rs.getLong(1);
        }
        connection.close();
        return ws;
    }

}