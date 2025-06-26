package leetcode.problems.p0207;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    private CourseSchedule courseSchedule = new CourseSchedule();

    @Test
    public void givenNonCyclicGraph_shouldReturnTrue() {
        int[][] coursePrerequesites = new int[][]{
                {0, 1}, {2, 0}, {3, 1}
        };
        int numCourses = 4;

        assertTrue(courseSchedule.canFinish(numCourses, coursePrerequesites));
    }

}