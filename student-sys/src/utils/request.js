import axios from 'axios'

const request = axios.create({
    baseURL: '', // 替换为你的API基础URL
    timeout: 5000, // 请求超时时间
    headers: {
        'Content-Type': 'application/json', // 设置默认请求头
    },
})

export default request