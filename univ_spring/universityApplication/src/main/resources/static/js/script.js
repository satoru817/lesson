document.addEventListener("DOMContentLoaded", function () {
  console.log("★");
  const header = document.querySelector("header");
  const htmlStr = `
  <nav>
    <h1>学生管理システム</h1>
    <a href="http://localhost:8080/admin/univ">TOP</a>
    <a href="http://localhost:8080/admin/univ/students">学生一覧</a>
    <a href="http://localhost:8080/admin/univ/courses">コース一覧</a>
  </nav>
  `;
  header.innerHTML += htmlStr;
});

/*相対パスでやろうとしたのですが、難しかったです。なので、とりあえず絶対パスにしています*/

/*
      <nav>
        <h1>学生管理システム</h1>
        <a href="index.html">TOP</a>
        <a href="students.html">学生一覧</a>
        <a href="courses.html">コース一覧</a>
      </nav>
      */
