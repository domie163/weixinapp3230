const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmff5gk/",
            name: "ssmff5gk",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmff5gk/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宿舍管理系统小程序"
        } 
    }
}
export default base
