package stats;

import java.util.*;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import controllers.ExternalWebSocketActor;
import io.ebean.*;
import models.Gesture;
import models.User;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class SessionModell  {

    public String id;
    public Gesture gesture;
    public User user;
    public int c_frames;
    public float c_duration;
    public float fps;

}