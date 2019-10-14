var createMember = {
    init : function () {
        var _this = this;
        $('#btn-login').on('click', function () {
            _this.login();
        });
    },
    login : function () {
        var data = {
            userId: $('#userId').val(),
            password: $('#password').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/login',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert('로그인이 되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error.responseText + " " + error.status);
        });
    }

};

createMember.init();