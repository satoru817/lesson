$('#add1').on('click', function (e) {
  e.preventDefault();
  const text = $('#today').val();
  console.log(text);
  $('#slide1').append(`<li>${text}</li>`);
});