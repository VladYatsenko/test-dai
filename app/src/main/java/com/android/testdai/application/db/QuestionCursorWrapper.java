package com.android.testdai.application.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.android.testdai.application.model.Question;
import com.android.testdai.application.model.Question.Answer;

import java.util.List;

public class QuestionCursorWrapper extends CursorWrapper {

    public QuestionCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Question getQuestion(List<Answer> answers){
        int idString = getInt(getColumnIndex((QuestionDbSchema.QuestionTable.Cols.ID)));
        String textQuestion = getString(getColumnIndex(QuestionDbSchema.QuestionTable.Cols.TEXTQUESTION));
        String imageSource = getString(getColumnIndex(QuestionDbSchema.QuestionTable.Cols.IMAGESOURCE));

        Question question = new Question();
        question.setId(idString);
        question.setTextQuestion(textQuestion);
        question.setWasAnswered(false);
        question.setWasSelected(false);
        question.setImageSource(imageSource);
        question.setAnswer(answers);

        return question;
    }

}