<template>
  <div class="page-container">
    <el-card>
      <div slot="header">
        <span>我的课表</span>
        <el-button type="danger" size="small" style="float: right" @click="dropAll">一键退课</el-button>
      </div>

      <el-empty v-if="myCourses.length === 0" description="暂未选择任何课程"></el-empty>

      <el-table v-else :data="myCourses" style="width: 100%">
        <el-table-column prop="name" label="课程名称"></el-table-column>
        <el-table-column prop="time" label="上课时间"></el-table-column>
        <el-table-column prop="location" label="地点"></el-table-column>
        <el-table-column prop="credits" label="学分"></el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-tag :type="scope.status === '正常' ? 'success' : 'warning'">{{ scope.row.status || '正常' }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button size="mini" type="danger" plain @click="dropCourse(scope.row)">退课</el-button>
          </template>
        </el-table-column>
      </el-table>
      
      <div style="margin-top: 20px; text-align: right; font-weight: bold;">
        总学分：{{ totalCredits }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      myCourses: [
        { name: '高等数学', time: '周一 08:00-10:00', location: 'A-101', credits: 4 },
        { name: '计算机网络', time: '周三 14:00-16:00', location: 'B-205', credits: 3 },
      ]
    };
  },
  computed: {
    totalCredits() {
      return this.myCourses.reduce((sum, item) => sum + item.credits, 0);
    }
  },
  methods: {
    dropCourse(course) {
      this.$confirm(`确定要退掉《${course.name}》吗？`, '退课警告', {
        type: 'warning'
      }).then(() => {
        const index = this.myCourses.indexOf(course);
        this.myCourses.splice(index, 1);
        this.$message.success('退课成功');
      }).catch(() => {});
    },
    dropAll() {
      if(this.myCourses.length === 0) return;
      this.$confirm('确定清空所有已选课程吗？此操作不可恢复', '高危操作', {
        type: 'error'
      }).then(() => {
        this.myCourses = [];
        this.$message.success('已清空所有课程');
      }).catch(() => {});
    }
  }
};
</script>