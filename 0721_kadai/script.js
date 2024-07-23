//警告文(20字以上)を出し、ボタンを無効化しopacityを変化させる関数
function alert(selector, num) {
  selector.on('input', function (e) {
    if (selector.val().trim().length > 20) {
      $(`#day${num}`).addClass('warn');
      $(`#warning${num}`).text("20字以内で入力してください");
      $(`#add${num}`).prop("disabled", true);
    } else {
      $(`#day${num}`).removeClass('warn');
      $(`#warning${num}`).text("");
      $(`#add${num}`).prop("disabled", false);
    }
  });
}


//スライドを上下させる関数
function toggleSlide(selector, flg) {
  selector.on('click', function (e) {
    flg *= -1;
    const id = e.target.id;
    const num = id.substring(6);
    console.log(num);
    if (flg < 0) {
      selector.html("&nbsp;▼");
    } else {
      selector.html("&nbsp;▲");
    }
    $(`#slide${num}`).slideToggle();
  });
}

$(function () {

  var slideFlg1 = 1;
  var slideFlg2 = 1;

  var $today = $('#day1');
  var $tomorrow = $('#day2');

  //20字より多いときの警告
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
  $(document).on('click', '.remove', function () {

    $(this).parent().remove();

  });

  //チェックボックスの機能
  $(document).on('change', '.toggle_lt', function () {

    $(this).parent().toggleClass('lt');

  });

  //スライドの機能

  toggleSlide($('#slider1'), slideFlg1);

  toggleSlide($('#slider2'), slideFlg2);


})



