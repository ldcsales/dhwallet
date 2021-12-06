package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
    class Spents(
        val image: String,
        val name: String,
        val type: SpentsType,
        val money: String
    ) : Parcelable{

    }


enum class SpentsType(val description: String) {
    PAGAMENTO("Pagamento"),
    DEPOSITO("Deposito"),
    SAQUE("Saque"),
    TRANSFERENCIA("Transferencia"),
}