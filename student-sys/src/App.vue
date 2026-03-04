<template>
  <div id="app">
    <!-- 路由视图：根据 URL 显示对应的组件 (Login, StudentInfo 等) -->
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  // 注意：这里不需要注册 HelloWorld，也不需要注册任何页面组件
  // 因为页面组件是通过 router-view 动态加载的
};
</script>

<style>
/* 全局重置样式 */
body {
  margin: 0;
  padding: 0;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

#app {
  width: 100%;
  height: 100%;
}

/* 移除默认的 img 样式，如果你不再需要 logo */
img {
  display: none; 
}
</style>