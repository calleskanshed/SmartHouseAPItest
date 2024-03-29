package smartHouse.resourceInterfaces;

import smartHouse.objectClasses.Room;
import smartHouse.resourceClasses.DeviceResource;
import smartHouse.resourceClasses.EnvironmentResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Patrik Glendell on 02/10/15.
 */

public interface RoomResourceInterface {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response createRoom(Room newRoom);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateRoom(@PathParam("id") int id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ConcurrentHashMap<Integer,Room> getAllRooms();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Room getRoom(@PathParam("id") int id);

    @DELETE
    @Path("{id}")
    Response deleteRoom(@PathParam("id") int id);

    @Path("{DeviceID : \\d+}/Device")
    default DeviceResource getDeviceResource() {
        return new DeviceResource();
    }
    @Path("Environment")
    default EnvironmentResource getEnvironmentResource() {
        return new EnvironmentResource();
    }


}
