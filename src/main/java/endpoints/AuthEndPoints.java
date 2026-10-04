package endpoints;

public class AuthEndPoints {

    public static final String Register = "/register";

    public static final String Login = "/login";

    public static final String GetOTP = "/test-support/otp?username=" + "USERNAME";

    public static final String VerifyOTP = "/verify-2fa/sms";

    public static final String Kyc = "/profiles/me/contact-info";
}
