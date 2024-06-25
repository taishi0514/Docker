
// $("form").submit(function() {

//     let self = this;
//   $(":submit", self).prop("disabled", true);
//       setTimeout(function() {
// $(":submit", self).prop("disabled", false);
//   }, 10000);
// });

document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');

    form.addEventListener('submit', function(event) {
        // フォームの送信ボタンを無効化
        const submitButton = form.querySelector(':submit');
        submitButton.disabled = true;

        // 10秒後に送信ボタンを再度有効化
        setTimeout(function() {
            submitButton.disabled = false;
        }, 10000);
    });
});





// console.log(typeof jQuery);
// $(document).ready(function() {
//     $("form").submit(function(event) {
//         let self = this;
//         $(":submit", self).prop("disabled", true);
//         console.log("フォームが送信されました。");

//         // Prevent default form submission
//         event.preventDefault();
        
//         $.ajax({
//             type: $(self).attr('method'),
//             url: $(self).attr('action'),
//             data: $(self).serialize(),
//             success: function(response) {
//                 console.log("登録が成功しました: ", response);
//                 alert("登録が成功しました！");
//                 $(":submit", self).prop("disabled", false); // 成功時にボタンを再度有効化
//             },
//             error: function(xhr, status, error) {
//                 console.log("登録中にエラーが発生しました: ", error);
//                 alert("登録中にエラーが発生しました。再度お試しください。");
//                 $(":submit", self).prop("disabled", false);
//             }
//         });

//         setTimeout(function() {
//             $(":submit", self).prop("disabled", false);
//             console.log("送信ボタンが再度有効化されました。");
//         }, 10000); // 10秒後に再度有効化
//     });
// });