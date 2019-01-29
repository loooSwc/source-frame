import axios from "axios";


export function tablePage (url,params,pageNum = 1,pageSize = 10) {
  let pageParams = {
    pageSize: pageSize,
    pageNumber: pageNum,
    params: params
  }
  return new Promise((resolve,reject) => {
    axios.post(url,pageParams)
      .then(response => {
        resolve(response);
      },err => {
        reject(err)
      })
  })
}

export default {
  tablePage
}
