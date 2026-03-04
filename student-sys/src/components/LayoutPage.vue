<template>
  <el-container style="height: 100vh;">
    <el-aside width="200px" style="background-color: #304156;">
      <div class="logo">教务系统</div>
      <el-menu
        background-color="#304156"
        text-color="#bfcbd9"
        active-text-color="#409EFF"
        :default-active="$route.path"
        router
      >
        <el-menu-item index="/students">
          <i class="el-icon-user"></i>
          <span slot="title">学生信息</span>
        </el-menu-item>
        <el-menu-item index="/course-select">
          <i class="el-icon-plus"></i>
          <span slot="title">选课中心</span>
        </el-menu-item>
        <el-menu-item index="/my-courses">
          <i class="el-icon-reading"></i>
          <span slot="title">已选课程</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    
    <el-container>
      <el-header style="background: #fff; border-bottom: 1px solid #dcdfe6; display: flex; align-items: center; justify-content: space-between;">
        <span>欢迎，张三同学</span>
        <el-button size="small" type="danger" @click="logout">退出登录</el-button>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Cookies from 'js-cookie'

export default {
  name: 'LayoutPage',
  methods: {
    logout() {
      // 清除登录状态
      Cookies.remove('studentInfo')
      this.$message.success('退出登录成功')
      this.$router.push('/')
    }
  }
};
</script>

<style scoped>
.logo {
  height: 60px;
  line-height: 60px;
  text-align: center;
  color: #fff;
  font-size: 20px;
  font-weight: bold;
  background-color: #2b3a4b;
}
.el-aside {
  color: #fff;
}
</style>