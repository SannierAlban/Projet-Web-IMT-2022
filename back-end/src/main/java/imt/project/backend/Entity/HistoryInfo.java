package imt.project.backend.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "history")
public class HistoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ia1")
    private Long ia1;

    @Column(name = "ia2")
    private Long ia2;

    @Column(name = "result")
    private Double result;

    @Column(name = "date")
    private Timestamp date;

    public HistoryInfo(Long ia1, Long ia2, Double result, Timestamp date) {
        this.ia1 = ia1;
        this.ia2 = ia2;
        this.result = result;
        this.date = date;
    }

    public HistoryInfo() {
    }

    @Override
    public String toString() {
        return "HistoryInfo{" +
                "id=" + id +
                ", ia1=" + ia1 +
                ", ia2=" + ia2 +
                ", result=" + result +
                ", date=" + date +
                '}';
    }
}
