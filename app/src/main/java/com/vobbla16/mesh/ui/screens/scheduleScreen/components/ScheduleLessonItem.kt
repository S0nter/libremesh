package com.vobbla16.mesh.ui.screens.scheduleScreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vobbla16.mesh.domain.model.schedule.Activity
import com.vobbla16.mesh.domain.model.schedule.LessonType
import kotlinx.datetime.LocalTime

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ScheduleLessonItem(activity: Activity.Lesson, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        onClick = onClick
    ) {
        Column(Modifier.padding(6.dp)) {
            Row {
                if (activity.lessonType == LessonType.OO) {
                    Text(text = activity.info, style = MaterialTheme.typography.labelMedium)
                    Spacer(Modifier.width(8.dp))
                }
                Text(
                    text = "${activity.beginTime} - ${activity.endTime}",
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = activity.room,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.basicMarquee(),
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Text(
                text = activity.subject,
                style = MaterialTheme.typography.titleMedium,
                lineHeight = 16.sp
            )
            activity.teacher?.let { teacher ->
                Text(text = teacher, style = MaterialTheme.typography.labelSmall)
            }

            if (activity.homework.isNotEmpty()) {
                Spacer(Modifier.height(6.dp))
                Text(
                    text = activity.homework,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            when (activity.lessonType) {
                LessonType.AE -> {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "дополнительное образование",
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.labelSmall
                    )
                }

                LessonType.EC -> {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "внеурочная деятельность",
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.labelSmall
                    )
                }

                else -> {}
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScheduleLessonItemPreview1() {
    ScheduleLessonItem(
        activity = Activity.Lesson(
            info = "1 урок",
            beginTime = LocalTime(8, 30),
            endTime = LocalTime(9, 15),
            scheduleItemId = 1,
            subject = "Математика",
            room = """каб. 37""",
            teacher = "Иванкова Алла Борисовна",
            marks = listOf(),
            homework = "Учебник страница 123, номер 123,412,1345(б)\nрабочая тетрадь стр 234, номер 412",
            lessonType = LessonType.OO
        ),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ScheduleLessonItemPreview2() {
    ScheduleLessonItem(
        activity = Activity.Lesson(
            info = "10 урок",
            beginTime = LocalTime(18, 56),
            endTime = LocalTime(20, 35),
            scheduleItemId = 1,
            subject = "Некое занятие с длинным названием прям просто капец лялялялял",
            room = "кабинет с длинным названием (ну прям оооооочень)",
            teacher = "Оченьдлиннов Сергейййййй Иваноооович",
            marks = listOf(),
            homework = "Учебник страница 123, номер 123,412,1345(б)\nрабочая тетрадь стр 234, номер 412 и ещё 200000000 номер череез неделю сдать и ещё раз ляляляляляляляляляляляляляллялялялляллялялляялляял",
            lessonType = LessonType.OO
        ),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ScheduleLessonItemPreview3() {
    ScheduleLessonItem(
        activity = Activity.Lesson(
            info = "1 урок",
            beginTime = LocalTime(8, 30),
            endTime = LocalTime(9, 15),
            scheduleItemId = 1,
            subject = "Математика",
            room = """каб. 37""",
            teacher = null,
            marks = listOf(),
            homework = "Учебник страница 123, номер 123,412,1345(б)\nрабочая тетрадь стр 234, номер 412",
            lessonType = LessonType.AE
        ),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ScheduleLessonItemPreview4() {
    ScheduleLessonItem(
        activity = Activity.Lesson(
            info = "10 урок",
            beginTime = LocalTime(18, 56),
            endTime = LocalTime(20, 35),
            scheduleItemId = 1,
            subject = "Некое занятие с длинным названием прям просто капец лялялялял",
            room = "КА №бинет с длинным названием (ну прям оооооочень)",
            teacher = "Оченьдлиннов Сергейййййй Иваноооович",
            marks = listOf(),
            homework = "Учебник страница 123, номер 123,412,1345(б)\nрабочая тетрадь стр 234, номер 412 и ещё 200000000 номер череез неделю сдать и ещё раз ляляляляляляляляляляляляляллялялялляллялялляялляял",
            lessonType = LessonType.EC
        ),
        onClick = {}
    )
}