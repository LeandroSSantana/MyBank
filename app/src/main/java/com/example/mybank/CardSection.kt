package com.example.mybank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.data.Card
import com.example.mybank.ui.theme.BlueEnd
import com.example.mybank.ui.theme.BlueStart
import com.example.mybank.ui.theme.DarkGrayEnd
import com.example.mybank.ui.theme.DarkGrayStart
import com.example.mybank.ui.theme.GreenEnd
import com.example.mybank.ui.theme.GreenStart
import com.example.mybank.ui.theme.OrangeEnd
import com.example.mybank.ui.theme.OrangeStart

val cards: List<Card> = listOf(

    Card(
        cardType = "Visa",
        cardNumber = "5308 8538 2007 5372",
        cardName = "Business",
        balance = 980.467,
        color = getGradient(DarkGrayStart, DarkGrayEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "5545 0341 7548 0995",
        cardName = "Savings",
        balance = 1.467888,
        color = getGradient(OrangeStart, OrangeEnd)
    ),

    Card(
        cardType = "Visa",
        cardNumber = "4929 7217 8217 9643",
        cardName = "School",
        balance = 117.90,
        color = getGradient(BlueStart, BlueEnd)
    ),

    Card(
        cardType = "Diners",
        cardNumber = "3677 790598 1156",
        cardName = "Trips",
        balance = 125.000,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}


@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(
                start = 16.dp, end = lastItemPaddingEnd
            )
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}