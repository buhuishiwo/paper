<template>
  <div class="page-container">
    <el-card>
      <div slot="header">
        <span>可选课程列表</span>
        <el-tag type="success" style="float: right">剩余学分：12</el-tag>
      </div>

      <el-table :data="courseList" style="width: 100%">
        <el-table-column prop="code" label="课程代码" width="120"></el-table-column>
        <el-table-column prop="name" label="课程名称"></el-table-column>
        <el-table-column prop="teacher" label="授课教师" width="120"></el-table-column>
        <el-table-column prop="credits" label="学分" width="80"></el-table-column>
        <el-table-column prop="capacity" label="容量/已选" width="120">
          <template slot-scope="scope">
            {{ scope.row.capacity }} / {{ scope.row.selected }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="120">
          <template slot-scope="scope">
            <el-button 
              type="primary" 
              size="small" 
              :disabled="scope.row.selected >= scope.row.capacity"
              @click="selectCourse(scope.row)">
              {{ scope.row.selected >= scope.row.capacity ? '已满' : '选课' }}
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      courseList: [
        { code: 'CS101', name: '高等数学', teacher: '张教授', credits: 4, capacity: 60, selected: 58 },
        { code: 'CS102', name: '数据结构', teacher: '李副教授', credits: 3, capacity: 45, selected: 45 }, // 已满
        { code: 'CS103', name: '计算机网络', teacher: '王讲师', credits: 3, capacity: 50, selected: 20 },
        { code: 'ART201', name: '艺术鉴赏', teacher: '赵老师', credits: 2, capacity: 100, selected: 12 },
      ]
    };
  },
  methods: {
    selectCourse(course) {
      this.$confirm(`确认选择课程《${course.name}》吗？`, '选课确认', {
        confirmButtonText: '确认选课',
        cancelButtonText: '再想想',
        type: 'info'
      }).then(() => {
        // 模拟后端更新
        course.selected++;
        this.$message.success('选课成功！');
      }).catch(() => {});
    }
  }
};
</script>