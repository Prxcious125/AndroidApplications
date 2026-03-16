package com.glenyxx.studentgradecalculatorkotlinversion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.glenyxx.studentgradecalculatorkotlinversion.ui.theme.StudentGradeCalculatorKotlinVersionTheme

// ✅ DATA CLASS — placed outside MainActivity
data class Student(
    val name: String,
    val score: Double?
)

// ✅ GRADE CALCULATOR FUNCTION — placed outside MainActivity
fun calculateGrade(score: Double?): String {
    val actualScore = score ?: 0.0
    return when {
        actualScore >= 90 -> "A"
        actualScore >= 80 -> "B"
        actualScore >= 70 -> "C"
        actualScore >= 60 -> "D"
        else              -> "F"
    }
}

// ✅ MAIN ACTIVITY
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ✅ CREATE YOUR STUDENTS HERE
        val students = listOf(
            Student(name = "Alice",   score = 85.5),
            Student(name = "Bob",     score = null),
            Student(name = "Charlie", score = 52.0),
            Student(name = "Diana",   score = 93.0),
            Student(name = "Eve",     score = 70.0)
        )

        setContent {
            StudentGradeCalculatorKotlinVersionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentReportScreen(
                        students = students,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// ✅ SCREEN COMPOSABLE — displays all student cards
@Composable
fun StudentReportScreen(students: List<Student>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Student Grade Calculator",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // ✅ LOOP THROUGH EACH STUDENT AND SHOW THEIR CARD
        students.forEach { student ->
            StudentCard(student = student)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

// ✅ INDIVIDUAL STUDENT CARD COMPOSABLE
@Composable
fun StudentCard(student: Student) {
    val grade = calculateGrade(student.score)
    val scoreDisplay = student.score?.toString() ?: "No score recorded"

    // Card colour changes based on grade
    val gradeColor = when (grade) {
        "A"  -> Color(0xFF388E3C)  // green
        "B"  -> Color(0xFF1976D2)  // blue
        "C"  -> Color(0xFFF57C00)  // orange
        "D"  -> Color(0xFFFBC02D)  // yellow
        else -> Color(0xFFD32F2F)  // red for F
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = student.name.uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = "Score : $scoreDisplay", fontSize = 15.sp)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Grade : $grade",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = gradeColor
            )
        }
    }
}

// ✅ PREVIEW — lets you see it in Android Studio's design panel
@Preview(showBackground = true)
@Composable
fun StudentReportPreview() {
    StudentGradeCalculatorKotlinVersionTheme {
        StudentReportScreen(
            students = listOf(
                Student(name = "Alice",   score = 85.5),
                Student(name = "Bob",     score = null),
                Student(name = "Charlie", score = 52.0),
                Student(name = "Diana",   score = 93.0),
                Student(name = "Eve",     score = 70.0)
            )
        )
    }
}
