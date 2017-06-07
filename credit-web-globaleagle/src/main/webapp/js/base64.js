//StringBuffer；
function StringBuffer() {
    var __str = new Array();
    this.append = function (s) {
        __str.push(s);
    };
    this.toString = function () {
        return __str.join("");
    }
}

var BASE64_KEY_STR = "ABCDEFGHIJKLMNOP" +
             "QRSTUVWXYZabcdef" +
             "ghijklmnopqrstuv" +
             "wxyz0123456789+/" +
             "=";

function base64Encode(input) {
    input = encodeURIComponent(input);
    var output = new StringBuffer();
    var chr1, chr2, chr3 = "";
    var enc1, enc2, enc3, enc4 = "";
    var i = 0;

    do {
        chr1 = input.charCodeAt(i++);
        chr2 = input.charCodeAt(i++);
        chr3 = input.charCodeAt(i++);

        enc1 = chr1 >> 2;
        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
        enc4 = chr3 & 63;

        if (isNaN(chr2)) {
            enc3 = enc4 = 64;
        } else if (isNaN(chr3)) {
            enc4 = 64;
        }

        output.append(BASE64_KEY_STR.charAt(enc1));
        output.append(BASE64_KEY_STR.charAt(enc2));
        output.append(BASE64_KEY_STR.charAt(enc3));
        output.append(BASE64_KEY_STR.charAt(enc4));
        chr1 = chr2 = chr3 = "";
        enc1 = enc2 = enc3 = enc4 = "";
    } while (i < input.length);

    return output.toString();
}

function base64Decode(input) {
    if (input == null || input == '') return '';
    var output = new StringBuffer();
    var chr1, chr2, chr3 = "";
    var enc1, enc2, enc3, enc4 = "";
    var i = 0, n = 0;

    // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
    var base64test = /[^A-Za-z0-9\+\/\=]/g;
    if (base64test.exec(input)) {
        alert("不是有效的Base64编码字符。");
        return "";
    }
    input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

    do {
        enc1 = BASE64_KEY_STR.indexOf(input.charAt(i++));
        enc2 = BASE64_KEY_STR.indexOf(input.charAt(i++));
        enc3 = BASE64_KEY_STR.indexOf(input.charAt(i++));
        enc4 = BASE64_KEY_STR.indexOf(input.charAt(i++));

        chr1 = (enc1 << 2) | (enc2 >> 4);
        chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
        chr3 = ((enc3 & 3) << 6) | enc4;

        output.append(String.fromCharCode(chr1));

        if (enc3 != 64) {
            output.append(String.fromCharCode(chr2));
        }
        if (enc4 != 64) {
            output.append(String.fromCharCode(chr3));
        }

        chr1 = chr2 = chr3 = "";
        enc1 = enc2 = enc3 = enc4 = "";

    } while (i < input.length);

    return decodeURIComponent(output.toString());
}