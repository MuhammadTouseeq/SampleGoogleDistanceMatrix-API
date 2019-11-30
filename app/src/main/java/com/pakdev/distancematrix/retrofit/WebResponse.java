package com.pakdev.distancematrix.retrofit;




import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class WebResponse<T> {

    private static final String KEY_ACCEPTED = "Accepted";

    @Nullable
    @SerializedName("message")
    private String Message;
    @Nullable
    @SerializedName("response")
    private T Result;
    @Nullable
    @SerializedName("status")
    private String Response;

    @SerializedName("isValid")
    private boolean isValid;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public boolean isSuccess() {
        if (isValid()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
