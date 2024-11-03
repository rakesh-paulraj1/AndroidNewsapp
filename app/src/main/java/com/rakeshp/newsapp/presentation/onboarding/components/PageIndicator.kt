
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.ui.theme.BlueGray
import com.loc.newsapp.ui.theme.NewsAppTheme
import com.rakeshp.newsapp.presentation.onboarding.Dimens.IndicatorSize
import com.rakeshp.newsapp.presentation.onboarding.OnBoardingScreen

@Composable
fun PageIndicator(modifier: Modifier = Modifier,pageSize:Int,selectedPage:Int,selectedColor: Color =MaterialTheme.colorScheme.primary,unseletedColor:Color= BlueGray) {
Row (modifier=modifier, horizontalArrangement = Arrangement.SpaceBetween){
repeat(pageSize){
    page -> Box(modifier= Modifier
    .size(IndicatorSize)
    .clip(CircleShape)
    .background(color = if (page == selectedPage) selectedColor else unseletedColor))
}
}
}
@Preview
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PageIndicatorPreview() {
PageIndicator(pageSize = 3, selectedPage = 0)
}