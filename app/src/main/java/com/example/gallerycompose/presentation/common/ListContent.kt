package com.example.gallerycompose.presentation.common

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.gallerycompose.R
import com.example.gallerycompose.data.model.UnsplashImage
import com.example.gallerycompose.data.model.Urls
import com.example.gallerycompose.data.model.User
import com.example.gallerycompose.data.model.UserLinks
import com.example.gallerycompose.ui.theme.HeartRed


@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>, context: Context) {
    Log.d("image", items.loadState.toString())
    LazyColumn(
        modifier = Modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = items.itemSnapshotList) { unsplashImage ->
            unsplashImage?.let { UnsplashItem(unsplashImage = unsplashImage, context = context) }
        }
    }
}

@Composable
fun UnsplashItem(
    unsplashImage: UnsplashImage,
    context: Context
) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(unsplashImage.urls.regular)
            .crossfade(1000)
            .error(R.drawable.place_holder)
            .placeholder(R.drawable.place_holder)
            .build()
    )

    Box(
        modifier = Modifier
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://unsplash.com/@${unsplashImage.user.username}?utm_source=PaginationCompose&utm_medium=referral")
                )
                startActivity(context, intent, null)
            }
            .height(300.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.BottomCenter

    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(0.5f),
            color = Color.Black
        ) {}

        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(unsplashImage.user.username)
                    }
                    append(" on Unsplash")
                },
                color = Color.White,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            LikeCounter(
                modifier = Modifier.weight(3f),
                painter = painterResource(id = R.drawable.heart),
                likes = "${unsplashImage.likes}"
            )

        }

    }


}

@Composable
fun LikeCounter(
    modifier: Modifier,
    painter: Painter,
    likes: String
) {
    Row(
        modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End

    ) {

        Icon(
            painter = painter,
            contentDescription = "likes",
            tint = HeartRed
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = likes,
            maxLines = 1,
            color = Color.White,
            fontSize = 14.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )

    }

}

@Composable
@Preview
fun UnsplashImagePreview() {
    UnsplashItem(
        unsplashImage = UnsplashImage(
            id = "1",
            urls = Urls(regular = ""),
            likes = 100,
            user = User(username = "Ebram Ibrahim", userLinks = UserLinks(html = ""))
        ),
        LocalContext.current
    )
}






















