import axios from "../../../axios/axios";

export function getUserDetail (_userId) {
  return axios.post('/api/sys/user/getUserDetail.do',{userId: _userId});
}

function addUser(_user) {
  return axios.post('/api/sys/user/addUser.do',_user);
}
function checkUserAccount(_userAccount) {
  return axios.post('/api/sys/user/checkUserAccount.do',_userAccount);
}
function getPassKey(params) {
  return axios.post('/api/user/login/getPassKey.do',params);
}
function editUser(_user) {
  return axios.post('/api/sys/user/editUser.do',_user);
}
function changeStatus(_user) {
  return axios.post('/api/sys/user/changeStatus.do',_user);
}

export default {
  getUserDetail,
  addUser,
  checkUserAccount,
  getPassKey,
  editUser,
  changeStatus
}
