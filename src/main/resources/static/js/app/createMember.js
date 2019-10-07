var createMember = {
    init : function () {
        var _this = this;
        $('#btn-createMember').on('click', function () {
            _this.create();
        });
    },
    create : function () {
        var data = {
            userId: $('#userId').val(),
            password: $('#password').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/createMember',
            // dataType: 'json', -> 성공할 때 리턴받을 타입으로 json을 기대,
            // 리턴타입이 json이 아닐 경우 http 요청은 성공하지만 fail이 발생하고 error.status가 200.
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error.responseText + " " + error.status);
        });
    }

};

createMember.init();