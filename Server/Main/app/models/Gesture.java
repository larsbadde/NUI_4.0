package models;

import java.util.*;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import controllers.ExternalWebSocketActor;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

/**
 * Created by Lars Badde
 */
@Entity
public class Gesture extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String description;


}