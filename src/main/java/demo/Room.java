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
    private Set<Room> rooms;


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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void addRoomTrack(Room room) {
        rooms.add(room);
    }
    public void removeRoomTrack(Room room) {
        rooms.remove(room);
    }

    public void update(Room room) {
        this.number = room.getNumber();
    }
}
