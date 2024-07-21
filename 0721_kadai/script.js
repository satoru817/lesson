$(function () {
  var cnt1 = 0;
  var cnt2 = 0;
  var cnt3 = 1;
  var cnt4 = 1;

  //追加ボタンの機能
  $('#add1').on('click', function (e) {
    e.preventDefault();//これがないとすぐ消えてしまう。
    //入力なしの判定
    if ($('#today').val() === "") {
      $('#today').addClass('warn');
      $('#warning1').text("入力必須です");
      //入力文字数の判定
    } else if ($('#today').val().length > 20) {
      $('#today').addClass('warn');
      $('#warning1').text("20字以内で入力してください");
      //入力が適正なときの動作
    } else {
      $('#today').removeClass('warn');
      $('#warning1').text("");
      //li要素を区別するためのcnt
      cnt1 += 1;
      const text = $('#today').val();
      const inputStatement = `<li id=${cnt1}><input type="checkbox" id ="${cnt1}" class="toggle_lt">${text}&nbsp;<button class="remove" id =${cnt1}>削除</button></li>`
      console.log(text);
      $('#slide1').append(inputStatement);
    }

  });

  $('#add2').on('click', function (e) {
    e.preventDefault();//これがないとすぐ消えてしまう。
    if ($('#tomorrow').val() === "") {
      $('#tomorrow').addClass('warn');
      $('#warning2').text("入力必須です");
    } else if ($('#tomorrow').val().length > 20) {
      $('#tomorrow').addClass('warn');
      $('#warning2').text("20字以内で入力してください");
    } else {
      $('#tomorrow').removeClass('warn');
      $('#warning2').text("");
      cnt2 -= 1;
      const text = $('#tomorrow').val();
      const inputStatement = `<li id=${cnt2}><input type="checkbox" id ="${cnt2}" class="toggle_lt">${text}&nbsp;<button class="remove" id =${cnt2}>削除</button></li>`
      console.log(text);
      $('#slide2').append(inputStatement);
    }

  });


  //削除ボタンの機能
  $(document).on('click', '.remove', function (e) {
    e.preventDefault();
    const id = this.id;
    console.log("ボタンが押されました" + this.id);
    $(`li#${id}`).remove();
  });

  //チェックボックスの機能
  $(document).on('change', '.toggle_lt', function (e) {
    e.preventDefault();
    const id = this.id;
    console.log("you checked me my id is" + id);
    $(`li#${id}`).toggleClass('lt');

  });

  //スライドの機能
  $('#slider1').on('click', function (e) {
    cnt3 *= -1;
    if (cnt3 < 0) {
      $('#slider1').html("&nbsp;▼");
    } else {
      $('#slider1').html("&nbsp;▲");
    }
    $("#slide1").slideToggle();
  });

  $('#slider2').on('click', function (e) {
    cnt4 *= -1;
    if (cnt4 < 0) {
      $('#slider2').html("&nbsp;▼");
    } else {
      $('#slider2').html("&nbsp;▲");
    }
    $("#slide2").slideToggle();
  });




})



