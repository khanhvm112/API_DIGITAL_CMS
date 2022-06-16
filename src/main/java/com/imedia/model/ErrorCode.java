package com.imedia.model;

public enum ErrorCode {
    SUCCESS_SYSTEM(200,"Giao dịch thành công",0),
    FAIlED_SYSTEM(201, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 0),
    INTERNAL_ERROR(500, "Hệ thống đang tạm thời gián đoạn, vui lòng thử lại sau", 0),
    UN_AUTHORIZE(401, "Xác thực lỗi,vui lòng đang nhập lại", 0),
    INCORRECT_USERNAME_OR_PASS(100, "Tài khoản hoặc mật khẩu không đúng", 0),
    NOT_FOUND_USER(101, "Thông tin tài khoản không tồn tại, vui lòng kiểm tra lại", 0),
    DECRYPT_DATA_FAILED(103, "Giải mã dữ liệu thất bại", 0),
    NOT_FOUND_SESSION(105, "Không tìm thấy session", 0),
    INTERNAL_ERROR_SYS(106, "Hệ thống tạm thời gián đoạn vui lòng thử lại sau", 0),
    INCORRECT_PHONE(115, "Số điện thoại không đúng", 0),
    NOT_ENOUGH_BALANCE(117, "Không đủ số dư để thực hiện giao dịch", 0),
    TRANS_FAILED(120, "Giao dịch không thành công,vui lòng thử lại sau", 0),
    ADD_FEE_FAILED(126, "Cộng tiền cho tài khoản thất bại", 0),
    NOT_FOUND_ACCOUNT(128, "Thông tin tài khoản nhận tiền không tồn tại, vui lòng kiểm tra lại", 0),
    PASS_TOO_LONG(133, "Độ dài mật khẩu vượt quá giới hạn cho phép, vui lòng kiểm tra lại", 0),
    INVALID_EMAIL(134, "Định dạng email không hợp lệ, vui lòng kiểm tra lại", 0),
    INCORRECT_OTP(135, "Mã OTP không đúng hoặc không tồn tại", 0),
    NOT_HAVE_PHONE(136, "Tài khoản không có số điện thoại,vui lòng cập nhật số điện thoại", 0),
    INCORRECT_USER_INFO_OR_WALLET_CODE(138, "Thông tin tài khoản không hợp lệ, vui lòng kiểm tra lại", 0),
    AMOUNT_PAYMENT_MUST_BE_POSITIVE(139, "Số tiền thanh toán phải lớn hơn 0", 0),
    EXISTED_PHONE_OR_ACCOUNT(140, "Thông tin tài khoản không hợp lệ, vui lòng kiểm tra lại", 0),
    EXISTED_EMAIL(141, "Email đã tồn tại, vui lòng kiểm tra lại", 0),
    NOT_EXIST_TRANS(142, "Thông tin giao dịch không tồn tại, vui lòng kiểm tra lại", 0),
    PARSER(666,"Thông tin giao dịch không chính xác, vui lòng kiểm tra lại",0),

    PAYMENT_NOT_ALLOW(402,"Phương thức thanh toán không hợp lệ, vui lòng kiểm tra lại",0),
    PHONE_INVALID(403,"Số điện thoại của bạn không hợp lệ, vui lòng kiểm tra lại",0),
    PHONE_TYPE_INVALID(405, "Thông tin thuê bao không hợp lệ, vui lòng kiểm tra lại", 0),

    NOT_EXIST_COMMISSION(302, "Không khởi tạo được chiết khấu cho tài khoản của bạn, vui lòng thử lại sau", 0),
    NOT_EXIST_PROVIDER(303,"Thông tin nhà cung cấp không tồn tại, vui lòng kiểm tra lại",0),
    NOT_EXIST_PRODUCT(304,"Thông tin sản phẩm không tồn tại, vui lòng kiểm tra lại",0),
    INCORRECT_PRODUCT(305, "Nhà cung cấp không hỗ trợ sản phầm này, vui lòng kiểm tra lại", 0),
    LIMIT_QUANTITY(306,"Số lượng đặt hàng vượt quá giới hạn, tối đa [x] sản phẩm",0),
    EMAIL_INVALID(307, "Email của bạn không hợp lệ, vui lòng kiểm tra lại", 0),

    NOT_EXIST_DEPT(308, "Quý khách không còn nợ hóa đơn.", 0),

    PAY_AMOUNT_INVALID(700, "Số tiền thanh toán không hợp lệ", 0),

    NOT_FOUND(1,"Không tìm thấy mã lỗi",0),
    //Direct topup
    TU_SUCCESS(3000,"Giao dịch thành công",1),

    TU_PENDING(3013,"Chưa rõ kết quả giao dịch",1),

    TU_TOKEN_NOT_EXISTED(3001,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_OTHER_REASON(3002,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_REQUEST_ID(3003,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_CORE_BUSY(3004,"Hệ thống đang tạm thời gián đoạn, vui lòng thực hiện lại sau",1),

    TU_NOT_ENOUGH_BALANCE(3005,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_TARGET_ACCOUNT(3006,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_TELCO_BUSY(3007,"Dịch vụ đang bảo trì, vui lòng thực hiện lại sau",1),

    TU_NOT_IN_TEMPLATE(3008,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_TRANS_DUP(3009,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_NOT_PERMISSION(3010,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_NOT_REGISTERED(3011,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_SP_NOT_EXISTED(3014,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_TARGET_NUMBER(3021,"Số điện thoại của bạn không hợp lệ, vui lòng kiểm tra lại",1),

    TU_TRANS_NOT_EXIST(3017,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    TU_LOCKED_PROVIDER(3019,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    //Download
    DL_SUCCESS(4000,"Giao dịch thành công",1),

    DL_TOKEN_NOT_EXISTED(4001,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_SOFT_PIN_NOT_ENOUGH(4003,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_SOFT_PIN_LIMIT_EXCEEDED(4004,"Số thẻ mua vượt quá số lượng cho phép, vui lòng kiểm tra lại",1),

    DL_AMOUNT_LIMIT_EXCEEDED(4005,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_INVALID_TARGET_ACCOUNT(4006,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_NOT_IN_TEMPLATE(4008,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_TRANSACTION_ID_DUPLICATE(4009,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_NOT_HAVE_PERMISSION(4010,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_PARTNER_NOT_ENOUGH_MONEY(4011,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_ENCRYPTED_KEY_INVALID(4012,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_TRANS_PENDING(4013, "Chưa rõ kết quả giao dịch", 1),

    DL_BUY_ITEM_DATA_IS_NOT_VALIDATED(4015,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    DL_TRANS_NOT_EXIST(4017,"Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại",1),

    //Billing
    BL_SUCCESS(5000, "Giao dịch thành công", 1),
    BL_PENDING(5099, "Chưa rõ kết quả giao dịch", 1),
    //failed
    BL_DEFAULT_FAILURE(5018, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_DEFAULT_PROVIDER(5019, "Có lỗi nhà cung cấp dịch vụ, vui lòng thử lại sau", 1),
    BL_MESSAGE_WRONG(5202, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_SERVICE_INCORRECT(5203, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_WRONG_PR_CODE(5204, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_DUPLICATE_TRANS_ID(5205, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_PARTNER_NOT_FOUND(5206, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_WRONG_AUTH_KEY(5207, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_AMOUNT_INVALID(5208, "Số tiền thanh toán không hợp lệ, vui lòng kiểm tra lại", 1),
    BL_SERVICE_INACTIVE(5209, "Dịch vụ hiện đang bảo trì, vui lòng thử lại sau", 1),
    BL_USER_WRONG(5210, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_TRANS_ID_NOTFOUND(5211, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_WRONG_TRANS_ID(5213, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_WRONG_ORIGINAL_TRANS_ID(5214, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_CANCEL_REJECT(5215, "Cancel reject", 1),
    BL_CONTAIN_SQL_COMMAND(5216, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_CANCEL_FIX_NOT_SUPPORT(5217, "Cancel fix not support", 1),
    BL_FIX_REJECT(5218, "Fix reject", 1),
    BL_FIX_BILLING_WAS_EXIST(5219, "Fix billing was exist", 1),
    BL_TRANSACTION_SAME_TIME(5220, "Mã hoá đơn đang được xử lý, vui lòng thử lại sau", 1),
    BL_FEE_NOT_CONFIG(5301, "Dịch vụ hiện đang bảo trì, vui lòng thử lại sau", 1),
    BL_GATEWAY_NOT_CONFIG(5302, "Dịch vụ hiện đang bảo trì, vui lòng thử lại sau", 1),
    BL_GATEWAY_DISABLED(5303, "Dịch vụ hiện đang bảo trì, vui lòng thử lại sau", 1),
    BL_PARTNER_INACTIVE(5304, "Dịch vụ hiện đang bảo trì, vui lòng thử lại sau", 1),
    BL_PARTNER_NOT_CONFIG(5305, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_NOT_ENOUGH_MONEY(5310, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_DEBIT_FAIL(5318, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_DEBIT_PENDING(5399, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_BILL_CODE_NOT_EXIST(5416, "Mã khách hàng không đúng, vui lòng kiểm tra lại", 1),
    BL_GW_PAY_BILL_WAS_CANCELLED(5417, "Pay bill was canceled", 1),
    BL_GW_PRECANCEL_PROCESSING(5418, "Precancel processing", 1),
    BL_GW_BILL_CODE_WRONG(5419, "Mã khách hàng không đúng hoặc không được dịch vụ hỗ trợ", 1),
    BL_GW_SYSTEM_TEMPORARILY_STOP(5420, "Dịch vụ hiện đang bảo trì, vui lòng thử lại sau", 1),
    BL_GW_SYSTEM_MAINTENANCE(5421, "Dịch vụ đang được nâng cấp, vui lòng thử lại sau", 1),
    BL_GW_DEBIT_EXCEEDED(5422, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_PAYMENT_FAILURE(5423, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_ACCOUNTING_ERROR(5424, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_ORDER_WAIT_PAID(5425, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_COMMISSION_NOT_CREATE(5426, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_BANK_INFO_ERROR(5427, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_DEBT_CHARGES_NOT_EXISt(5428, "Hoá đơn không còn nợ cước", 1),
    BL_GW_PAYMENT_CODE_NOT_EXIST(5429, "Mã khách hàng không đúng, vui lòng kiểm tra lại", 1),
    BL_GW_PAY_SERVICE_STOPPED(5431, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_NOT_ELIGIBLE_FOR_PAYMENT(5432, "Số điện thoại của bạn không hợp lệ, vui lòng kiểm tra lại", 1),
    BL_GW_QUERY_FAIL(5433, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_FAILURE_FROM_NCC(5438, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_TELE_CHARGE_FAIL(5439, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    BL_GW_TELEPHONE_WRONG(5440, "Số điện thoại của bạn không hợp lệ, vui lòng kiểm tra lại", 1),
    BL_GW_ORIGINAL_TRANS_ID_NOT_EXIST(5441, "Original transaction id not exist", 1),

    //Lucky Best
    LB_ERROR(6000, "Có lỗi nhà cung cấp dịch vụ, vui lòng thử lại sau", 1),
    LB_QUERY_PAID(6001, "Giao dịch đã thanh toán", 1),
    LB_QUERY_CANCELLED(6002, "Giao dịch đã hủy", 1),
    LB_PENDING(6099, "Chưa rõ kết quả giao dịch", 1),
    LB_SUCCESS(6100, "Thanh toán thành công, vui lòng truy cập LuckyBest để kiểm tra thông tin vé", 1),
    LB_TRANS_NOT_EXIST(6101, "Giao dịch hết hạn hoặc không tồn tại", 1),
    LB_TOKEN_INVALID(6102, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    LB_SIGNATURE_INVALID(6103, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    LB_REQUEST_INVALID(6120, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    LB_TRANS_STATUS_INVALID(6121, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    LB_PAYMENT_INVALID(6130, "Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại", 1),
    LB_TICKET_ERROR(6200, "Giao dịch thất bại do vé in không thành công", 1),

    //MB Bank
    MB_INVALID_TOKEN(7401, "Token không hợp lệ.", 1)
    ;

    public final Integer code;
    public final String message;
    public final int type;

    ErrorCode(Integer code, String message, int type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }

    public static ErrorCode valueOf(int value, int type) {
        for (ErrorCode val : values()) {
            if (val.code == value)
                return val;
        }
        return ErrorCode.NOT_FOUND;
    }

    public static ErrorCode valueOf(int value) {
        for (ErrorCode val : values()) {
            if (val.code == value)
                return val;
        }
        return ErrorCode.NOT_FOUND;
    }
}
