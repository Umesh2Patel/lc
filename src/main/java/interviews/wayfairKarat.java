package interviews;

/*
Solution- https://leetcode.com/discuss/interview-question/647667/Roblox-Karat-Interview
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students, a collection of all courses they share.

Sample Input:

student_course_pairs_1 = [
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
  ["58", "Software Design"],
]

Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
  "58,17": ["Software Design", "Linear Algebra"]
  "58,94": ["Economics"]
  "58,25": ["Economics"]
  "94,25": ["Economics"]
  "17,94": []
  "17,25": []
}



Additional test cases:

Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:

find_pairs(student_course_pairs_2) =>
{
  "0,42": []
  "0,9": []
  "9,42": []
}



n: number of student,course pairs in the input
s: number of students
c: number of courses being offered

*/

import org.apache.poi.hssf.model.WorkbookRecordList;

import java.io.*;
        import java.util.*;

public class wayfairKarat {
    public static void main(String[] argv) {
        String[][] studentCoursePairs1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}
        };

        String[][] studentCoursePairs2 = {
                {"42", "Software Design"},
                {"0", "Advanced Mechanics"},
                {"9", "Art History"},
        };
        System.out.println(findPairs(studentCoursePairs1));
        System.out.println(findPairs(studentCoursePairs2));


    }
    public static Map<int[], List<String>> findPairs(String[][] input){
        Map<int[], List<String>> result = new HashMap<>();
        Map<Integer, Set<String>> adjList = new HashMap();
        List<Integer> studentIds = new ArrayList();

        for(String[] course : input){
            int studentId = Integer.parseInt(course[0]);
            if(!adjList.containsKey(studentId))
                studentIds.add(studentId);
            adjList.putIfAbsent(studentId, new HashSet());
            adjList.get(studentId).add(course[1]);
        }
        for(int i =0; i<studentIds.size(); i++){
            int curr = studentIds.get(i);
            for(int j = i+1; j<studentIds.size(); j++){
                List<String> commonCourses = findCommon(studentIds.get(j), curr, adjList);
                result.put(new int[]{curr, studentIds.get(j)}, commonCourses);
            }
        }
        return result;
    }

    public static List<String> findCommon(int id1, int id2, Map<Integer, Set<String>> adjMap){
        Set<String> student1 = adjMap.get(id1);
        Set<String> student2 = adjMap.get(id2);
        List<String> common = new ArrayList();
        for(String course : student1){
            if(student2.contains(course)){
                common.add(course);
            }
        }
        return common;
    }
}

