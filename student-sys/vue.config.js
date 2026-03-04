const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // 替换为你的API服务器地址
        changeOrigin: true,
        pathRewrite: {
          '^/api': '/api', // 将/api前缀替换为空
        },
      },
    },
  },
})
