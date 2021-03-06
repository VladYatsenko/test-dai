package com.android.testdai.model.enities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "answer")
class AnswerEntity constructor(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "_id")
        var id: Int?,

        @ColumnInfo(name = "name_answer")
        var text: String?,

        @ColumnInfo(name = "correct")
        var isCorrect: Boolean?,

        @ColumnInfo(name = "fk_question")
        var questionId: Int?,
        @ColumnInfo(name = "isSelected")
        var isSelected: Boolean? = false,
        @ColumnInfo(name = "isAnswered")
        var isAnswered: Boolean? = false
)