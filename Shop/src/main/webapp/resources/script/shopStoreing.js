var shopStoreing = {
    //封装Ajax相关的URL
    URL: {
        verifyCustomer: function () {
            return '/shop/shops' + '/verifyCustomer'
        },
        verifyAdmin: function () {
            return '/shop/shops' + '/verifyAdmin'
        },
        addItemToCar: function () {
            return "/shop/shops" + '/addItemToCar'
        }
    },

    //验证用户名和密码
    validateUser: function (username, password, userType) {
        if (!username || !password) {
            return "nothing"
        } else {
            if (shopStoreing.verifyWithDatabase(username, password, userType)) {
                return "success";
            } else {
                return "mismatch";
            }
        }
    },
    verifyWithDatabase: function (username, password, userType) {
        var result = false;
        var params = {};
        var verifyUrl = '';
        params.username = username;
        params.password = password;
        if (userType == 'user') {
            verifyUrl = shopStoreing.URL.verifyCustomer();
        } else if (userType == 'admin') {
            verifyUrl = shopStoreing.URL.verifyAdmin();
        }
        $.ajax({
            type: "post",
            url: verifyUrl,
            data: params,
            dataType: "json",
            async: false,//同步调用，保证先执行result=true,后再执行return result;
            success: function (data) {
                if (data.result == "SUCCESS") {
                    window.location.reload();
                    //弹出登录成功
                    alert("登录成功");
                    result = true;
                } else {
                    result = false;
                }
            }
        });
        return result;
    },
    //商品列表页面
    list: {
        init: function () {
            var firstNumber = 1, secondNumber = 2, thirdNumber = 3, forthNumber = 4, fifthNumber = 5, recordNumber = 5;
            shopStoreing.list.pageCompomentInit(firstNumber, secondNumber, thirdNumber, forthNumber, fifthNumber, recordNumber);
            $("#next").click(function () {
                $('#first-column').text(firstNumber + 5);
                $('#second-column').text(secondNumber + 5);
                $('#third-column').text(thirdNumber + 5);
                $('#forth-column').text(forthNumber + 5);
                $('#fifth-column').text(fifthNumber + 5);
                firstNumber += 5;
                secondNumber += 5;
                thirdNumber += 5;
                forthNumber += 5;
                fifthNumber += 5;
                $('#previous').show();
            });
            $("#previous").click(function () {
                $('#first-column').text(firstNumber - 5);
                $('#second-column').text(secondNumber - 5);
                $('#third-column').text(thirdNumber - 5);
                $('#forth-column').text(forthNumber - 5);
                $('#fifth-column').text(fifthNumber - 5);
                firstNumber -= 5;
                secondNumber -= 5;
                thirdNumber -= 5;
                forthNumber -= 5;
                fifthNumber -= 5;
                if (fifthNumber <= 5) {
                    $("#previous").hide();
                }
            });
            flag = 0;
            firstColumn = '#first-column';
            secondColumn = '#second-column';
            thirdColumn = '#third-column';
            forthColumn = '#forth-column';
            fifthColumn = '#fifth-column';
            $(firstColumn).click(function () {
                shopStoreing.list.columnListData(firstColumn);
            });
            $(secondColumn).click(function () {
                shopStoreing.list.columnListData(secondColumn);
            });
            $(thirdColumn).click(function () {
                shopStoreing.list.columnListData(thirdColumn);
            });
            $(forthColumn).click(function () {
                shopStoreing.list.columnListData(forthColumn);
            });
            $(fifthColumn).click(function () {
                shopStoreing.list.columnListData(fifthColumn);
            });
        },
        columnListData: function (column) {
            var columnNumber = $(column).text();
            var recordNumber = $("#recordNumber").val();
            var params = {};
            if (column == firstColumn) {
                flag = 1;
            } else if (column == secondColumn) {
                flag = 2;
            } else if (column == thirdColumn) {
                flag = 3;
            } else if (column == forthColumn) {
                flag = 4;
            } else if (column == fifthColumn) {
                flag = 5;
            }
            params['columnNumber'] = columnNumber;
            params['recordNumber'] = recordNumber;
            $('#shopList').empty();
            $.ajax({
                type: "get",
                url: "/shop/shops/page",
                data: params,
                async: false,
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        $('#shopList').append(
                            '<tr>' +
                            '<td> ' + result[i].id + '</td>' +
                            '<td> ' + result[i].title + '</td>' +
                            '<td> ' + result[i].price + '</td>' +
                            '<td> ' + result[i].number + '</td>' +
                            '<td> ' + result[i].status + '</td>' +
                            '<td> ' + result[i].created + '</td>' +
                            '<td><a class="btn btn-info" href="/shop/shops/' + result[i].id + '/detail" >详细</a></td>' +
                            '</tr>'
                        )
                    }
                    $('#shopList').html();
                }
            });
        },
        pageCompomentInit: function (firstNumber, secondNumber, thirdNumber, forthNumber, fifthNumber, recordNumber) {
            $('#first-column').text(firstNumber);
            $('#second-column').text(secondNumber);
            $('#third-column').text(thirdNumber);
            $('#forth-column').text(forthNumber);
            $('#fifth-column').text(fifthNumber);
            $('#recordNumber').text(recordNumber);
            $('#previous').hide();
        }
    },
    //商详情页面
    detail:
        {
            init: function (params) {
                var id = params['id'];
                var username = $.cookie('username');
                var password = $.cookie('password');
                var userType = '';
                if (!username || !password) {
                    //设置登录层属性
                    var IdAndPasswordModal = $('#chooseModel');
                    var userModel = $('#userModel');
                    IdAndPasswordModal.modal({
                        show: true,//显示弹出层
                        backdrop: 'static',//禁止位置关闭
                        keyboard: false//关闭键盘事件
                    });
                    $('#userLogin').click(function () {
                        userModel.modal({
                            show: true,//显示弹出层
                            backdrop: 'static',//禁止位置关闭
                            keyboard: false//关闭键盘事件
                        });
                        $('#userText').html('<h3>用户登录</h3>');
                        userType = 'user';
                    });
                    $('#adminLogin').click(function () {
                        userModel.modal({
                            show: true,//显示弹出层
                            backdrop: 'static',//禁止位置关闭
                            keyboard: false//关闭键盘事件
                        });
                        $('#userText').html("<h3>管理员登录</h3>");
                        userType = 'admin';
                    });
                    $('#userBtn').click(function () {
                        if (userType == 'user') {
                            shopStoreing.detail.userLogin(username, password, userType);
                        } else if (userType == 'admin') {
                            shopStoreing.detail.userLogin(username, password, userType);
                        }
                    });
                } else {
                    var shopBox = $('#shop-box');
                    shopStoreing.detail.addItem(id, username, shopBox);
                }

            },
            userLogin: function (username, password, userType) {
                username = $('#userIdKey').val();
                password = $('#passwordKey').val();
                //调用validateUser函数来验证用户的账号
                var temp = shopStoreing.validateUser(username, password, userType);
                if (temp == 'nothing') {
                    $('#userMessage').html('<label class="label label-danger">账号或密码为空</label>').show();
                    setTimeout(function () {
                        $('#userMessage').hide();
                    }, 1000);
                } else if (temp == 'mismatch') {
                    $('#userMessage').html('<label class="label label-danger">帐号密码不匹配!</label>').show();
                    setTimeout(function () {
                        $('#userMessage').hide();
                    }, 1000);
                } else if (temp == "success") {
                    //学号与密码匹配正确，将学号密码保存在cookie中。不设置cookie过期时间，这样即为session模式
                    $.cookie('username', username, {path: '/'});
                    $.cookie('password', password, {path: '/'});
                    $.cookie('userType', userType, {path: '/'});
                }
            },
            addItem: function (id, username, node) {
                node.html('\<input value="1" name="number" id="shopNumber" style="width: 100px;height: 40px" />\<button class="btn btn-primary btn-lg" id="addBtn">加入购物车</button>');
                var purchaseUrl = shopStoreing.URL.addItemToCar(id, username);
                //绑定点击事件
                $('#addBtn').click(function () {
                    //执行加入购物车请求
                    //1丶先禁用请求
                    $(this).addClass("disabled");
                    //发送请求

                });
            }
        }
};