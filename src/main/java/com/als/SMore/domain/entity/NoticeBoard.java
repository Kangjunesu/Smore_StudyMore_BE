package com.als.SMore.domain.entity;

import com.als.SMore.study.notice.DTO.NoticeRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notice_board")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_board_pk")
    private Long noticeBoardPk;

    @ManyToOne
    @JoinColumn(name = "study_pk", nullable = false)
    @JsonIgnore
    private Study study;

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Column(name = "notice_content", nullable = false)
    private String noticeContent;

    public NoticeBoard(NoticeRequestDTO requestDTO, Study study){
        this.study = study;
        this.noticeTitle = requestDTO.getNoticeTitle();
        this.noticeContent = requestDTO.getNoticeContent();
    }

    public void updateNotice(NoticeRequestDTO requestDTO){
        this.noticeTitle = requestDTO.getNoticeTitle();
        this.noticeContent = requestDTO.getNoticeContent();
    }

}
