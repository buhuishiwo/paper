<template>
  <div class="page-container">
    <el-card>
      <div slot="header">
        <span>可选课程列表</span>
        <el-tag type="success" style="float: right">剩余学分：12</el-tag>
      </div>

      <el-table :data="courseList" style="width: 100%">
        <el-table-column prop="id" label="课程代码" width="120"></el-table-column>
        <el-table-column prop="courseName" label="课程名称"></el-table-column>
        <el-table-column prop="teacher" label="授课教师" width="120"></el-table-column>
        <el-table-column prop="point" label="学分" width="80"></el-table-column>
        <el-table-column prop="capacity" label="容量/已选" width="120">
          <template slot-scope="scope">
            {{ scope.row.maxCapacity }} / {{ scope.row.selectedCount }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="120">
          <template slot-scope="scope">
            <el-button 
              type="primary" 
              size="small" 
              :disabled="scope.row.selectedCount >= scope.row.maxCapacity"
              @click="selectCourse(scope.row)">
              {{ scope.row.selectedCount >= scope.row.maxCapacity ? '已满' : '选课' }}
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
import Cookies from "js-cookie"
import {getCourseList,selectCourseApi} from "@/api/course"

export default {
  data() {
    return {
      courseList: []
    }
  },

  created() {
    this.loadCourses()
  },

  methods: {
    loadCourses() {
      getCourseList().then(res => {
        if(res.data.code === 200) {
          this.courseList = res.data.data
        }
      })
    },

    selectCourse(row) {
      
      const studentInfo = JSON.parse(Cookies.get('studentInfo'))
      const studentId = studentInfo.id

      selectCourseApi({
        studentId: studentId,
        courseId: row.id
      }).then(res => {
         if (res.data.code === 200) {
          this.$message.success("选课成功")
          this.loadCourses()  // 刷新列表
        } else {
          this.$message.error(res.data.message)
        }
      })
    }
  }
};
</script>