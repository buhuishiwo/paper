import request from '@/utils/request'

// 查询课程
export function getCourseList() {
  return request.get('/api/course/list')
}

// 选课
export function selectCourseApi(data) {
  return request.post('/api/selection/select', data)
}