package Lombok.model.taskModel;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "pf_data", schema = "public", catalog = "etpreport")
@Data
@NoArgsConstructor
public class PfData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "task_id", insertable = false, updatable = false)
    // @ForeignKey(name = "task_id")
    private Long task_id;

    @Column(name = "work_description")
    private String workDescription;

    @Column(name = "tr_text")
    private String trText;

    @Column(name = "pmi_task_text")
    private String pmiTaskText;

    @Column(name = "pmi_result_text")
    private String pmiResultText;

    @OneToOne
    @JoinColumn(name = "task_source_id", referencedColumnName = "id")
    @ToString.Exclude
    private Task taskSourceId;

    @OneToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    @ToString.Exclude
    private Task task;
}
