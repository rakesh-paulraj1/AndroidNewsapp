package com.rakeshp.newsapp.presentation.onboarding

import PageIndicator
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.ui.theme.NewsAppTheme
import com.rakeshp.newsapp.presentation.common.NewsButton
import com.rakeshp.newsapp.presentation.common.NewsTextButton
import com.rakeshp.newsapp.presentation.onboarding.Dimens.MediumPadding2
import com.rakeshp.newsapp.presentation.onboarding.Dimens.PageIndicatorWidth
import com.rakeshp.newsapp.presentation.onboarding.components.OnBoardingPage
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable

fun OnBoardingScreen(event: (OnBoardingEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }


        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75f) // Ensures it takes 75% of the available vertical space
        ) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.height(16.dp)) // Spacer between pager and indicator


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(PageIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MediumPadding2),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val scope = rememberCoroutineScope()


                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage > 0) {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        }
                    )
                } else {
                    Spacer(modifier = Modifier.width(80.dp))
                }


                NewsButton(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == pages.size - 1) {
                            event(OnBoardingEvent.SaveAppEntry)
                            } else {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    }
                )
            }
        }





        Spacer(modifier = Modifier.height(16.dp))
    }
}


