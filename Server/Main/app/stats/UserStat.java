package stats;

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

@Entity
public class UserStat  {

    public Long id;
    public String prename;
    public String surname;
    public boolean right_handed;
    public int c_gestures;
    public int c_sessions;
    public long c_frames;
    public long c_duration;

}