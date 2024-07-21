//警告文(20字以上)を出す関数
function alert(selector, num) {
  selector.on('input', function (e) {
    if (selector.val().trim().length > 20) {
      $(`#day${num}`).addClass('warn');
      $(`#warning${num}`).text("20字以内で入力してください");
      $(`#add${num}`).addClass('alert');
    } else {
      $(`#day${num}`).removeClass('warn');
      $(`#warning${num}`).text("");
      $(`#add${num}`).removeClass('alert');
    }
  });
}

$(function () {

  var slide1 = 1;
  var slide2 = 1;

  var $today = $('#day1');
  var $tomorrow = $('#day2');

  alert($today, 1);
  alert($tomorrow, 2);




  //追加ボタンの機能
  $('button[id^=add]').on('click', function (e) {
    //e.preventDefault();//これがないとすぐ消えてしまったのはformタグの中だったから？

    //イベントを発生させた要素のidを取得
    const id = e.target.id;
    //今日と明日を区別するためのnum
    const num = id.substring(3);
    if ($(`#day${num}`).val().trim() === "") {
      $(`#day${num}`).addClass('warn');
      $(`#warning${num}`).text("入力必須です");
      //入力文字数の判定
    } else if ($(`#day${num}`).val().trim().length > 20) {
      $(`#day${num}`).addClass('warn');
      $(`#warning${num}`).text("20字以内で入力してください");
      //入力が適正なときの動作
    } else {
      $(`#day${num}`).removeClass('warn');
      $(`#warning${num}`).text("");

      const text = $(`#day${num}`).val();
      const inputStatement = `<li><input type="checkbox" class="toggle_lt">${text}&nbsp;<button class="remove">削除</button></li>`
      console.log(text);
      $(`#slide${num}`).append(inputStatement);
    }

  });




  //削除ボタンの機能
  $(document).on('click', '.remove', function (e) {

    $(this).parent().remove();

  });

  //チェックボックスの機能
  $(document).on('change', '.toggle_lt', function (e) {

    $(this).parent().toggleClass('lt');

  });

  //スライドの機能
  $('#slider1').on('click', function (e) {
    slide1 *= -1;
    if (slide1 < 0) {
      $('#slider1').html("&nbsp;▼");
    } else {
      $('#slider1').html("&nbsp;▲");
    }
    $("#slide1").slideToggle();
  });

  $('#slider2').on('click', function (e) {
    slide2 *= -1;
    if (slide2 < 0) {
      $('#slider2').html("&nbsp;▼");
    } else {
      $('#slider2').html("&nbsp;▲");
    }
    $("#slide2").slideToggle();
  });




})



