package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name="speaker_id", referencedColumnName = "id")
    private Person speaker;

    @OneToOne
    @JoinColumn(name="locationRoom_id", referencedColumnName = "id")
    private Room locationRoom;

    @ManyToMany(mappedBy = "tracks")
    private Set<Person> attendees;

    @ManyToMany(mappedBy = "rooms")
    private Set<Room> locations;

    public Track() {

    }
    public Track(String title, String description, Person speaker, Room locationRoom) {
        this.title = title;
        this.description = description;
        this.speaker = speaker;
        this.locationRoom = locationRoom;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Person getSpeaker() {
        return speaker;
    }

    public Room getLocationRoom() { return  locationRoom;}

    public Set<Person> getAttendees() {
        return attendees;
    }

    public Set<Room> getLocations() {
        return locations;
    }

    public void update (Track track) {
        this.title = track.getTitle();
        this.description = track.getDescription();
        this.speaker = track.getSpeaker();
        this.locationRoom = track.getLocationRoom();
    }
}
