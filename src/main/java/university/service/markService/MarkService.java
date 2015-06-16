package university.service.markService;

import university.entity.Mark;

import java.util.List;

public interface MarkService {

    void addMark(Mark mark);
    Mark getMarkById(Integer id);
    List getAllMarks();
    void deleteMark(Mark mark);
}
