package demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="number", nullable = false)
    private Integer number;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "location",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))
    private Set<Track> tracks;


    public Room() {

    }
    public Room(Integer number) {
        this.number = number;
    }
    public long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void addRoomTrack(Track track) {
        tracks.add(track);
    }
    public void removeRoomTrack(Track track) {
        tracks.remove(track);
    }

    public void update(Room room) {
        this.number = room.getNumber();
    }
}
