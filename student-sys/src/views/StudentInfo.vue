<template>
  <div class="profile-container">
    <el-row :gutter="20">
      <!-- 左侧：头像与基本状态 -->
      <el-col :span="8">
        <el-card shadow="hover">
          <div class="avatar-box">
            <el-avatar :size="120" :src="studentInfo.avatar || defaultAvatar"></el-avatar>
            <h3 class="name">{{ studentInfo.name }}</h3>
            <el-tag type="success" effect="dark">{{ studentInfo.status }}</el-tag>
            <p class="student-id">学号：{{ studentInfo.id }}</p>
          </div>
          
          <el-divider></el-divider>
          
          <div class="info-item">
            <span class="label">学院：</span>
            <span class="value">{{ studentInfo.college }}</span>
          </div>
          <div class="info-item">
            <span class="label">专业：</span>
            <span class="value">{{ studentInfo.major }}</span>
          </div>
          <div class="info-item">
            <span class="label">班级：</span>
            <span class="value">{{ studentInfo.class }}</span>
          </div>
          <div class="info-item">
            <span class="label">入学年份：</span>
            <span class="value">{{ studentInfo.enrollmentYear }}</span>
          </div>
        </el-card>
      </el-col>

      <!-- 右侧：详细档案表单 -->
      <el-col :span="16">
        <el-card shadow="never">
          <div slot="header" class="clearfix">
            <span>个人详细档案</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="editMode = !editMode">
              {{ editMode ? '取消编辑' : '编辑资料' }}
            </el-button>
          </div>

          <el-form :model="studentInfo" label-width="100px" :disabled="!editMode">
            <el-row>
              <el-col :span="12">
                <el-form-item label="姓名">
                  <el-input v-model="studentInfo.name"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="性别">
                  <el-radio-group v-model="studentInfo.gender">
                    <el-radio label="男">男</el-radio>
                    <el-radio label="女">女</el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="出生日期">
                  <el-date-picker 
                    v-model="studentInfo.birthDate" 
                    type="date" 
                    placeholder="选择日期" 
                    style="width: 100%"
                    value-format="yyyy-MM-dd">
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系电话">
                  <el-input v-model="studentInfo.phone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <el-form-item label="电子邮箱">
                  <el-input v-model="studentInfo.email"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <el-form-item label="家庭住址">
                  <el-input type="textarea" :rows="3" v-model="studentInfo.address"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <el-form-item label="个人简介">
                  <el-input type="textarea" :rows="4" v-model="studentInfo.bio" placeholder="介绍一下自己..."></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <!-- 保存按钮区域 -->
            <div v-if="editMode" style="text-align: right; margin-top: 20px;">
              <el-button @click="editMode = false">取消</el-button>
              <el-button type="primary" @click="saveProfile" :loading="saving">保存修改</el-button>
            </div>
          </el-form>
        </el-card>

        <!-- 学术概况卡片 -->
        <el-card shadow="never" style="margin-top: 20px;">
          <div slot="header">
            <span>学业概况</span>
          </div>
          <el-row :gutter="20" style="text-align: center;">
            <el-col :span="8">
              <div class="stat-box">
                <div class="stat-num">{{ studentInfo.gpa }}</div>
                <div class="stat-label">平均绩点 (GPA)</div>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="stat-box">
                <div class="stat-num">{{ studentInfo.creditsEarned }} / {{ studentInfo.totalCredits }}</div>
                <div class="stat-label">已获学分 / 总学分</div>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="stat-box">
                <div class="stat-num">{{ studentInfo.ranking }}</div>
                <div class="stat-label">专业排名</div>
              </div>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'StudentInfo',
  data() {
    return {
      editMode: false,
      saving: false,
      defaultAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      // 模拟当前登录学生的数据 (实际项目中应从 API 获取)
      studentInfo: {
        id: '2023001',
        name: '张三',
        gender: '男',
        avatar: '', 
        status: '在读',
        college: '计算机学院',
        major: '软件工程',
        class: '2301班',
        enrollmentYear: '2023',
        birthDate: '2005-06-15',
        phone: '13800138000',
        email: 'zhangsan@university.edu.cn',
        address: '某某大学学生公寓 A 栋 302 室',
        bio: '热爱编程，喜欢篮球。',
        gpa: 3.85,
        creditsEarned: 45,
        totalCredits: 160,
        ranking: '5/120'
      }
    };
  },
  methods: {
    saveProfile() {
      this.saving = true;
      // 模拟保存请求
      setTimeout(() => {
        this.saving = false;
        this.editMode = false;
        this.$message.success('个人信息更新成功！');
        // 这里可以调用 API: axios.put('/api/student/profile', this.studentInfo)
      }, 800);
    }
  }
};
</script>

<style scoped>
.profile-container {
  padding: 20px;
  background-color: #f0f2f5;
  min-height: 100%;
}

.avatar-box {
  text-align: center;
  padding: 20px 0;
}

.name {
  margin: 15px 0 10px;
  font-size: 24px;
  color: #303133;
}

.student-id {
  color: #909399;
  margin-top: 10px;
  font-size: 14px;
}

.info-item {
  display: flex;
  justify-content: space-between;
  padding: 12px 0;
  border-bottom: 1px solid #f0f0f0;
}

.info-item:last-child {
  border-bottom: none;
}

.info-item .label {
  color: #606266;
  font-weight: bold;
}

.info-item .value {
  color: #303133;
}

.stat-box {
  padding: 20px;
  background: #f5f7fa;
  border-radius: 4px;
}

.stat-num {
  font-size: 28px;
  font-weight: bold;
  color: #409EFF;
  margin-bottom: 5px;
}

.stat-label {
  font-size: 14px;
  color: #909399;
}
</style>