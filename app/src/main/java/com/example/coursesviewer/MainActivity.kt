package com.example.coursesviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesviewer.data.DataSource
import com.example.coursesviewer.model.Topic
import com.example.coursesviewer.ui.theme.CoursesViewerTheme


var topics = DataSource.topics
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsList(topics)

                }
            }
        }
    }
}

@Composable
fun TopicsList (topicsList: List<Topic>,modifier: Modifier = Modifier){

    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier

    ){
        items(topicsList) { topic ->
            CourseCard(
                topic = topic,
                modifier = Modifier
            )
        }
    }
}


@Composable
fun CourseCard (topic: Topic, modifier: Modifier = Modifier){
    Card(
        modifier = Modifier
            .height(68.dp)

    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
        ){
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = null,
                modifier = Modifier
                    .size(68.dp)
                    .padding(end = 4.dp)
            )

            Column (
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(start = 16.dp)
            ){

                Text(
                    text = stringResource(topic.name),
                    maxLines = 1,
                    modifier = Modifier
                        .padding(end = 16.dp)


                )

                Row (
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier

                ){


                    Icon (
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier

                    )

                    Text(
                        text = topic.cant.toString(),
                        modifier = Modifier
                            .padding(start  = 8.dp)
                        )



                }

            }




        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesViewerTheme {
        TopicsList(DataSource.topics)
        //Greeting("Android")
    }
}