<template>
    <div class="login-container">
        <el-card class="login-card">
            <h2 class="title">教务管理系统</h2>
            <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="80px">
                <el-form-item label="学号" prop="username">
                    <el-input v-model="loginForm.username" placeholder="请输入学号"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"
                        @keyup.enter.native="handleLogin"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" style="width: 100%" :loading="loading" @click="handleLogin">
                        登 录
                    </el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script>

import { login } from '@/api/student'
import Cookies from 'js-cookie'

export default {
    name:'LoginPage',
    data() {
        return {
            loading: false,
            loginForm: {
                username: '',
                password: ''
            },
            rules: {
                username: [{ required: true, message: '请输入学号', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
            }
        }
    },
    methods: {
        handleLogin() {
           login({
                username: this.loginForm.username,
                password: this.loginForm.password
           }).then(res => {
                if (res.data.code === 200) {
                     Cookies.set('studentInfo', JSON.stringify(res.data.data), { expires: 1 })
                    this.$message.success('登录成功')
                    this.$router.push('/students')
                } else {
                    this.$message.error(res.data.message)
                    console.log(res)
                }
            }).catch(() => {
                this.$message.error('登录请求失败')
            })
           
        }
    }
}
</script>

<style scoped>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f2f5;
}

.login-card {
    width: 400px;
}

.title {
    text-align: center;
    margin-bottom: 30px;
    color: #409EFF;
}
</style>